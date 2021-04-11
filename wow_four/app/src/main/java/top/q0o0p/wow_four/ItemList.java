package top.q0o0p.wow_four;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

public class ItemList extends AppCompatActivity {
    private Button btn_remove3;
    private Button btn_alter;
    private ListView list_one;
    private MyAdapter mAdapter = null;
    private List<Data> mData = null;
    private Context mContext = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext =ItemList.this;

        mData = new LinkedList<Data>();
        mAdapter = new MyAdapter((LinkedList<Data>) mData, mContext);
        list_one.setAdapter(mAdapter);
 /*       btn_remove3 =  findViewById(R.id.btn_remove3);
        btn_remove3.setOnClickListener(this);

        btn_alter =  findViewById(R.id.btn_remove2);
        btn_alter.setOnClickListener(this);
*/
    }
/*        @Override
    public void onClick(View v) {
            switch (v.getId()) {

                case R.id.btn_alter:
                    mAdapter.add(new Data("  "+"给猪哥跪了~~~ x " , "123"));
                    break;
                case R.id.btn_remove3:
                    mAdapter.remove(2);
                    break;
            }

    }*/
}
