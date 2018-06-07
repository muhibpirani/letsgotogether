package android.weildy.letsgotogether.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.weildy.letsgotogether.R;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by muhib on 10/12/2017.
 */
public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ViewHolder> {
    private List<List<String>> data;
    private List<String> singleRow;
    private Context context;

    public CustomListAdapter( Context context,List<List<String>> data) {
        this.data = data;
        this.context=context;
        singleRow=new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        singleRow = data.get(position);
        holder.txt_no.setText("Name:"+singleRow.get(0));
        holder.txt_title.setText("No:"+singleRow.get(1));
        holder.txt_price.setText("Price:"+singleRow.get(2));


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_title, txt_no,txt_price;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            txt_no = (TextView) itemView.findViewById(R.id.txt_no);
            txt_price=(TextView)itemView.findViewById(R.id.txt_price);
        }
    }
}
