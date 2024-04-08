package com.example.formativa1corte2;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerFragment extends Fragment {
    String[] paises = {"España", "Filipinas", "Colombia", "Argentina", "Canada"};
    int[] banderas = {R.drawable.spain, R.drawable.filipinas, R.drawable.colombia, R.drawable.argentina, R.drawable.canada};
    Spinner spinner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spinner, container, false);
        spinner = view.findViewById(R.id.spinner);
        PaisesAdapter adaptador1 = new PaisesAdapter();
        spinner.setAdapter(adaptador1);
        return view;

    }

    class PaisesAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return paises.length;
        }

        @Override
        public Object getItem(int position) {
            return paises[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.contenido, parent, false);
            ImageView iv1 = convertView.findViewById(R.id.imageView);
            TextView tv1 = convertView.findViewById(R.id.bandera);
            iv1.setImageResource(banderas[position]);
            tv1.setText(paises[position]);

            return convertView;
        }
    }
}