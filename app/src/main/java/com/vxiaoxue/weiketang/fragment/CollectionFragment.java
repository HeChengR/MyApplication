package com.vxiaoxue.weiketang.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.vxiaoxue.weiketang.R;

/**
 * Created by Administrator on 2015/8/26.
 */
public class CollectionFragment extends Fragment {
    private    ListView collection_listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.collection_fragment,container);
        collection_listView = (ListView)view.findViewById(R.id.collection_listView);
        CollectionAdapter collectionAdapter = new CollectionAdapter();
        collection_listView.setAdapter(collectionAdapter);
        return view;
    }


    public class CollectionAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(getActivity(),R.layout.collection_item,null);
            return convertView;
        }
    }
}
