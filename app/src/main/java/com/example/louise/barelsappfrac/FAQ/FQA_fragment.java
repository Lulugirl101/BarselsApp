package com.example.louise.barelsappfrac.FAQ;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


import com.example.louise.barselsapp.R;

// Frequentlt asked questions. Skal indeholde en liste med mest stillede spørgsmål. Kilde taget fra Rishospitalets hjemmeside.
// Source : http://stackoverflow.com/questions/24083886/expandablelistview-in-fragment-issue
// Datasource: https://www.rigshospitalet.dk/afdelinger-og-klinikker/julianemarie/obstetrisk-klinik/efter-foedslen-barsel/amning/Sider/ofte-stillede-spoergsmaal--faq.aspx#hvorforamme
/*
*  @author Louise Janø
* */
public class FQA_fragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("FAQ","onCreate");
        Resources res = getResources();
        groups = res.getStringArray(R.array.fagtitels);


        children = new String[][]{  //Todo: make backend med alt dette text
                {getActivity().getString(R.string.ernæring) +
                        getActivity().getString(R.string.ernæring1) +
                        getActivity().getString(R.string.ernæring2) +
                        getActivity().getString(R.string.ernæring3) +
                         getActivity().getString(R.string.ernæring4)},
                {getActivity().getString(R.string.amning) +
                        getActivity().getString(R.string.amning1) +
                        getActivity().getString(R.string.amning2) +
                        getActivity().getString(R.string.amning3) +
                        getActivity().getString(R.string.amning4) +
                        "\n" +
                        getActivity().getString(R.string.amning5) +
                        "\n" +
                        getActivity().getString(R.string.amning6) +
                        "\n" +
                        getActivity().getString(R.string.amning7) +
                        "\n" +
                        getActivity().getString(R.string.amning8) +
                        "\n" +
                        getActivity().getString(R.string.amning9) +
                        getActivity().getString(R.string.amning10) +
                        getActivity().getString(R.string.amning11) +
                        getActivity().getString(R.string.amning12) +
                        getActivity().getString(R.string.amning13)},
                 {getActivity().getString(R.string.parat)},
                 {getActivity().getString(R.string.tegn)},
                 {getActivity().getString(R.string.synkelyde) +
                        getActivity().getString(R.string.synkelyde1) +
                        getActivity().getString(R.string.synkelyde2)},
                 {getActivity().getString(R.string.godt_fat) +
                        getActivity().getString(R.string.godt_fat1) +
                        getActivity().getString(R.string.godt_fat2) +
                        getActivity().getString(R.string.godt_fat3) +
                        getActivity().getString(R.string.godt_fat4) +
                        getActivity().getString(R.string.godt_fat5) +
                        getActivity().getString(R.string.godt_fat6) +
                        getActivity().getString(R.string.godt_fat7) +
                        getActivity().getString(R.string.godt_fat8) +
                        getActivity().getString(R.string.godt_fat9) +
                        getActivity().getString(R.string.godt_fat10) +
                        getActivity().getString(R.string.godt_fat11)},
                {getActivity().getString(R.string.betændelse) +
                        getActivity().getString(R.string.betændelse1)},
                {getActivity().getString(R.string.tøj) +
                        getActivity().getString(R.string.tøj1) +
                        getActivity().getString(R.string.tøj2) +
                        getActivity().getString(R.string.tøj3) +
                        "\n" +
                        getActivity().getString(R.string.tøj4) +
                        "\n" +
                        getActivity().getString(R.string.tøj5)},
                {getActivity().getString(R.string.sår) +
                        getActivity().getString(R.string.sår2)},
                {getActivity().getString(R.string.revne) +
                        getActivity().getString(R.string.revne1) +
                        getActivity().getString(R.string.revne2) +
                        getActivity().getString(R.string.revne3) +
                        getActivity().getString(R.string.revne4)},
                {getActivity().getString(R.string.ammeløb)},
                {getActivity().getString(R.string.hjælp_kontakt) +
                        "\n" +
                        getActivity().getString(R.string.hjælp_kontakt1)}
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            Log.d("FAQ","onCreateView");
           return inflater.inflate(R.layout.fragment_fqa_fragment, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = (ExpandableListView) view.findViewById(R.id.exlist);
        lv.setAdapter(new ExpandableListAdapter(groups, children));
        lv.setGroupIndicator(null);

    }

    public class ExpandableListAdapter extends BaseExpandableListAdapter {

        private final LayoutInflater inf;
        private String[] groups;
        private String[][] children;

        public ExpandableListAdapter(String[] groups, String[][] children) {
            this.groups = groups;
            this.children = children;
            inf = LayoutInflater.from(getActivity());
        }

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_item, parent, false);
                holder = new ViewHolder();

                holder.text = (TextView) convertView.findViewById(R.id.lblListItem);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getChild(groupPosition, childPosition).toString());

            return convertView;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_group, parent, false);

                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.lblListHeader);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getGroup(groupPosition).toString());

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        private class ViewHolder {
            TextView text;
        }


    }

    public void onStart()
    { Log.d("FAQ", "onStart()");
        super.onStart(); }
    public void onAttach(){
        super.onAttach(getActivity());
    }
    public void onResume()
    { Log.d("FAQ","onResume()");
        super.onResume(); }
    public void onPause()
    { Log.d("FAQ","onPause()"); super.onPause(); }
    public void onStop()
    { Log.d("FAQ","onStop()"); super.onStop(); }
    public void onDestroy()
    { Log.d("FAQ","onDestroy()"); super.onDestroy(); }


}
