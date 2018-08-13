package dra.com.mvvmpatternstudy.Model.Interpreter.Adpater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import dra.com.mvvmpatternstudy.Model.Singleton.SharedInstance;
import dra.com.mvvmpatternstudy.R;

public class CommandListAdapter extends RecyclerView.Adapter<CommandListAdapter.ViewHolder> {

    ArrayList<CommandListItem> items;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView commandView;
        public TextView countView;

        public ViewHolder(View itemView) {
            super(itemView);

            commandView = itemView.findViewById(R.id.s_item_command);
            countView = itemView.findViewById(R.id.s_item_count);
        }
    }

    public CommandListAdapter(ArrayList<CommandListItem> items) {
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
        String command = items.get(position).getCommand();
        int indentationLevel = items.get(position).getIndentationLevel();

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
                Toast.makeText(v.getContext().getApplicationContext(), "Command Index : " + position +" Command Name : " +items.get(position).getCommand(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return (items == null) ? 0 : items.size();
    }
}
