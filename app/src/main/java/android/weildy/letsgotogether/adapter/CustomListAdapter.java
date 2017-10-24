package android.weildy.letsgotogether.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.weildy.letsgotogether.R;
import android.weildy.letsgotogether.http.model.ListBean;
import android.widget.TextView;

import java.util.List;

/**
 * Created by muhib on 10/12/2017.
 */
public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ViewHolder> {
    private List<ListBean> listBeans;

    public CustomListAdapter(List<ListBean> listBeans) {
        this.listBeans = listBeans;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_row, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListBean listBean = listBeans.get(position);
        holder.txt_no.setText(listBean.getNo());
        holder.txt_title.setText(listBean.getTitle());

    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_title, txt_no;

        public ViewHolder(View itemView) {
            super(itemView);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            txt_no = (TextView) itemView.findViewById(R.id.txt_no);
        }
    }
}
