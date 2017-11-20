package com.v.property;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/19.
 */

public class Adapter extends BaseAdapter{

    private List<MyObserver> list;
    private Context context;

    public Adapter(List<MyObserver> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(context,R.layout.item,null);
            holder.tvName=convertView.findViewById(R.id.tvName);
            holder.tvAge=convertView.findViewById(R.id.tvAge);
            holder.tvSex=convertView.findViewById(R.id.tvSex);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        MyPerson myPerson = list.get(position).getMyPerson();

        if(myPerson!=null){
            holder.tvName.setText(myPerson.getName());
            holder.tvAge.setText(myPerson.getAge()+"");
            holder.tvSex.setText(myPerson.getSex());
        }


        return convertView;
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvAge;
        TextView tvSex;
    }



}
