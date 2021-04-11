package top.q0o0p.wow_four;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView list_one;

    private MyAdapter mAdapter = null;
    private List<Data> mData = null;
    private Context mContext = null;
    private Button btn_add;
    private Button btn_add2;
    private Button btn_alter;
    private Button btn_remove2;
    TextView old_name;

    private MyCallBack myCallBack;
    private int flag ;
    private String TAG="q0o0p";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        bindViews();
        mData = new LinkedList<Data>();
        mAdapter = new MyAdapter((LinkedList<Data>) mData,mContext);
        list_one.setAdapter(mAdapter);


        btn_add =  findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);


        btn_remove2 =  findViewById(R.id.btn_remove2);
        btn_remove2.setOnClickListener(this);

        /*btn_alter = list_one.findViewById(R.id.btn_alter);
        btn_alter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

    }
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View dialogView = getLayoutInflater().inflate(R.layout.address_list, null);
        View itemList = getLayoutInflater().inflate(R.layout.item_list, null);

        EditText name=dialogView.findViewById(R.id.et_name);
        EditText phone= dialogView.findViewById(R.id.et_phone);


        switch (v.getId()){

              /*  case R.id.btn_alter:
                flag++;
                mAdapter.add(new Data(flag+"  "+"hhh~~ x " , "123"));
                break;*/
            case R.id.btn_add:
                builder.setIcon(R.drawable.ic_user)
                        .setTitle("")
                        .setView(dialogView)
                        .setPositiveButton("确认添加", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                        mAdapter.add(new Data(String.valueOf(name.getText().toString()) ,String.valueOf(phone.getText().toString())));
                                flag++;
                                Log.e(TAG, "onClick: 添加成功" );
//                                Toast.makeText(this, "", Toast.LENGTH_LONG).show();

                            }

                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.e(TAG, "onClick: 取消" );
                            }
                        })
                        .create()
                        .show();
                break;

                case R.id.btn_remove2:
                mAdapter.clear();
                break;

        }

    }

    public void changeListView(View view) {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View dialogView = getLayoutInflater().inflate(R.layout.address_list, null);
        View itemList = getLayoutInflater().inflate(R.layout.item_list, null);

        EditText name=dialogView.findViewById(R.id.et_name);
        EditText phone= dialogView.findViewById(R.id.et_phone);
//        name.setText(old_name);
               final EditText et_name_dialog = (EditText) name.findViewById(R.id.et_name);
        et_name_dialog.setText(old_name.getText().toString());


        builder.setIcon(R.drawable.ic_user)
             .setView(dialogView)
                .setPositiveButton("确认修改", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        old_name.setText(et_name_dialog.getText().toString());
                        Toast.makeText(MainActivity.this, String.valueOf(name.getText().toString())+"修改"+flag, Toast.LENGTH_SHORT).show();
                        phone.setText(phone.getText().toString());
                        Data data1= new Data(name.getText().toString(), phone.getText().toString());
                        /*if (myCallBack != null) {
                            myCallBack.myBack(data1);
                        }*/

//                        mAdapter.add(new Data(flag+String.valueOf(name.getText().toString()),String.valueOf(phone.getText().toString())));
//                        mAdapter.updateButtonAction();
                        Toast.makeText(MainActivity.this, data1.getPhone()+"修改成功"+flag, Toast.LENGTH_SHORT).show();

                        Log.e(TAG, "onClick: 修改成功");
//                                Toast.makeText(this, "", Toast.LENGTH_LONG).show();

                    }

                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Log.e(TAG, "onClick: 取消" );
                    }
                })
                .create()
                .show();



        //调用adapter的通知方法告诉listview数据已经改变
        mAdapter.notifyDataSetChanged();
        myCallBack = new MyCallBack() {
            @Override
            public void myBack(Data data) {
               /* data.setName(name.getText().toString());
                data.setPhone(phone.getText().toString());*/
                name.setText(data.getName());
                phone.setText(data.getPhone());
            }
        };
    }
    private void updateListItem(int postion,Data mData){
        int visiblePosition = list_one.getFirstVisiblePosition();
        View v = list_one.getChildAt(postion - visiblePosition);
        TextView phone = (TextView) v.findViewById(R.id.phone);
        TextView name = (TextView) v.findViewById(R.id.name);
        phone.setText(mData.getPhone());
        name.setText(mData.getName());
    }
    private void bindViews(){
        list_one = findViewById(R.id.list_one);
    }


}
