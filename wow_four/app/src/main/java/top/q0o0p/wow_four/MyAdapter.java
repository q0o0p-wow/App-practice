package top.q0o0p.wow_four;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private LinkedList<Data> mData;


    public MyAdapter() {}

    public MyAdapter(LinkedList<Data> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list,parent,false);
            holder = new ViewHolder();

            holder.phone =  convertView.findViewById(R.id.phone);
            holder.remove =  convertView.findViewById(R.id.btn_remove3);
//            holder.alter =  convertView.findViewById(R.id.btn_alter);
            holder.name = convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.phone.setText(mData.get(position).getPhone());
        holder.name.setText(mData.get(position).getName());

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.remove(getItem(position));
                notifyDataSetChanged();
            }
        });
       /* holder.alter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateButtonAction(position);
                notifyDataSetChanged();
            }
        });*/
        return convertView;
    }

    private class ViewHolder{
        TextView phone;
        TextView name;

        Button remove;
        Button alter;

    }

    //往特定位置，添加一个元素

    public void add(Data data) {
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }
    public void alter(int position,Data data) {
        Data data1 = mData.get(position);
        data.setName(data.getName() + position);
        data.setPhone(data.getPhone()+position);
        mData.set(position, data);

        notifyDataSetChanged();
    }



    public void remove(int position) {
        if(mData != null) {
            mData.remove(position);
        }
        notifyDataSetChanged();
    }


    public void clear() {
        if(mData != null) {
            mData.clear();
        }
        notifyDataSetChanged();
    }


    public void updateButtonAction(int position){

        Data data = mData.get(position);
        data.setName(data.getName() + position);
        data.setPhone(data.getPhone()+position);
        mData.set(position, data);
        notifyDataSetChanged();

    }


    public String getName(int position) {
        Data data = mData.get(position);
        return data.getName();
    }
    public String getPhone(int position) {
        Data data = mData.get(position);
        return data.getPhone();
    }



}
