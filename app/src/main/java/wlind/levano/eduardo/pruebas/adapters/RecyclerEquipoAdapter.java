package wlind.levano.eduardo.pruebas.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import wlind.levano.eduardo.pruebas.R;

public class RecyclerEquipoAdapter extends RecyclerView.Adapter<RecyclerEquipoAdapter.MyViewHolder>{


    private LayoutInflater mInflater;
    private List<String> mDummy;


    public RecyclerEquipoAdapter(Context context, List<String> data){
        this.mInflater = LayoutInflater.from(context);
        this.mDummy = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.model_list_team, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String hola= mDummy.get(position);
        holder.setData(hola, 2);
    }

    @Override
    public int getItemCount() {
        return mDummy.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txtNombreEquipo);
        }

        public void setData(String i, int position){
            this.title.setText(i);
        }
    }
}
