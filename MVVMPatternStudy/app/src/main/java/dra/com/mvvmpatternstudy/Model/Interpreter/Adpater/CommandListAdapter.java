package dra.com.mvvmpatternstudy.Model.Interpreter.Adpater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import dra.com.mvvmpatternstudy.Model.Interpreter.Context.InterpreterContext;
import dra.com.mvvmpatternstudy.Model.Interpreter.Context.NodeParseException;
import dra.com.mvvmpatternstudy.Model.Interpreter.Nodes.ProgramNode;
import dra.com.mvvmpatternstudy.Model.Interpreter.Nodes.RootNode;
import dra.com.mvvmpatternstudy.Model.Singleton.SharedInstance;
import dra.com.mvvmpatternstudy.R;

public class CommandListAdapter extends RecyclerView.Adapter<CommandListAdapter.ViewHolder> {
    RootNode rootNode = new ProgramNode();
    ArrayList<String> items;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView commandView;
        public TextView countView;

        public ViewHolder(View itemView) {
            super(itemView);

            commandView = itemView.findViewById(R.id.s_item_command);
            countView = itemView.findViewById(R.id.s_item_count);
        }
    }

    public CommandListAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.item_command, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        String indentationText = "";
        String commadResult = "";

        for(int j = 0; j < getItemCount(); j++) {
            commadResult = commadResult + " " + items.get(j);
        }

        parseInterpreter(commadResult);

        String command = items.get(position);
        int indentationLevel = CommandInstance.getInstance().getCommandListItemIndentation(position);

        for (int i = 0; i < indentationLevel; i++) {
            indentationText = indentationText + "       ";
        }

        holder.commandView.setText(indentationText + command);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SharedInstance.getInstance().setTaskPostion(position+1);
             //   InterpreterActivity.editInterpreterText.setSelection();
                Toast.makeText(v.getContext().getApplicationContext(), "Command Index : " + position +" Command Name : " +items.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return (items == null) ? 0 : items.size();
    }

    public void parseInterpreter(String fullTxt) {

        // 3. TestActivity(View) 에게서 데이터를 전달 받고 Interpreter - node 에 데이터 전달
        try {
            rootNode.parse(new InterpreterContext(fullTxt));
        } catch (NodeParseException e) {
            e.printStackTrace();

//            Intent intent = new Intent(mContext, PopupActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            intent.putExtra("errorToken", fullTxt);
//            mContext.getApplicationContext().startActivity(intent);
    }

        // 5. rootNode 의 변경값을 TestActivity(View) 에게 View 갱신
        //InterpreterActivity.textInterpreterResult.setText(rootNode.toString());

    }
}
