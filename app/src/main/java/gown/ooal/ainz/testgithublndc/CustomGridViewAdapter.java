package gown.ooal.ainz.testgithublndc;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *
 * @author manish.s
 *
 */
public class CustomGridViewAdapter extends ArrayAdapter<Dice> {
    Context context;
    int layoutResourceId;
    ArrayList<Dice> data = new ArrayList<Dice>();

    public CustomGridViewAdapter(Context context, int layoutResourceId,
                                 ArrayList<Dice> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
            holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
            holder.button = (Button)row.findViewById(R.id.button_number);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        Dice item = data.get(position);
        holder.txtTitle.setText(item.getName());
        holder.button.setText(String.valueOf(item.getSides().size()));
        //holder.imageItem.setImageBitmap();
        return row;

    }

    static class RecordHolder {
        TextView txtTitle;
        ImageView imageItem;
        Button button;
    }
}