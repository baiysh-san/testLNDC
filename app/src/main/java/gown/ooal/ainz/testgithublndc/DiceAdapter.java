package gown.ooal.ainz.testgithublndc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DiceAdapter extends BaseAdapter {

    private  final LayoutInflater mInflater;

    public DiceAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return DiceList.getDices().size();
    }

    @Override
    public Object getItem(int position) {
        return DiceList.getDices().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
