package com.example.simao;

import android.widget.Filter;

import com.example.simao.Model.GetSparepart;

import java.util.ArrayList;

public class SparepartFilter extends Filter{

    SparepartAdapter adapter;
    ArrayList<GetSparepart> filterList;

    public SparepartFilter(ArrayList<GetSparepart> filterList, SparepartAdapter adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;
    }

    protected Filter.FilterResults performFiltering(CharSequence constraint) {
        Filter.FilterResults results=new Filter.FilterResults();
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<GetSparepart> filteredSparepart=new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getNAMA_SPAREPART().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredSparepart.add(filterList.get(i));
                }
            }
            results.count=filteredSparepart.size();
            results.values=filteredSparepart;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;
        }
        return results;
    }

    protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
        adapter.spareparts= (ArrayList<GetSparepart>) results.values;
        //REFRESH
        adapter.notifyDataSetChanged();
    }
}


