package com.example.louise.barelsappfrac.FAQ;


import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;


import com.example.louise.barselsapp.R;

import java.util.ArrayList;

// Frequentlt asked questions. Skal indeholde en liste med mest stillede spørgsmål
// Source : http://stackoverflow.com/questions/24083886/expandablelistview-in-fragment-issue
// Datasource: https://www.rigshospitalet.dk/afdelinger-og-klinikker/julianemarie/obstetrisk-klinik/efter-foedslen-barsel/amning/Sider/ofte-stillede-spoergsmaal--faq.aspx#hvorforamme

public class FQA_fragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] groups;
    private String[][] children;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Resources res = getResources();
        groups = res.getStringArray(R.array.fagtitels);
       // groups = new String[]{R.string.faq1, "Test Header 2", "Test Header 3", "Test Header 4"};

        children = new String[][]{  //Todo: make backend med alt dette text
                {"Det er perfekt ernæring til jeres barn.\n" +
                        "Der er tæt kontakt mellem mor og barn.\n" +
                        "Det er praktisk og nemt.\n" +
                        "Amning har en forebyggende virkning i forhold til fx infektionssygdomme, mave-tarmsygdomme og mellemørebetændelse.\n" +
                        "Det optimerer barnets fysiske og mentale udvikling."},
                {"Barn skal virke veltilpas mellem amningerne.\n" +
                        "Afføringen skal være blød og gullig (børn skal have afføring hver dag den første måned, de kan godt have det flere gange om dagen).\n" +
                        "Bleerne skal være våde.\n" +
                        "Barnet skal være interesseret i kontakt, når det er vågent.\n" +
                        "Barnet bør få mindst seks måltider i døgnet.\n" +
                        "\n" +
                        "Nogle børn kan spise sig mætte i løbet af 20 min. mens andre har brug for længere tid.\n" +
                        "\n" +
                        "I timerne efter barnet har suttet første gang, kan det godt være træt og sove mange timer. Vil barnet i dagene efter fødslen igen sove i lang tid, bør barnet vækkes efter ca. 3-4 timer og tilbyde mad.\n" +
                        "\n" +
                        "Får barnet ikke det det har brug for kan det skyldes at barnet bliver lagt til for sjælden eller ikke sutter tilstrækkelig længe ved det enkelte bryst, til at få den fede mælk. Desuden er det vigtigt at barnet har rigtigt fat om brystet. \n" +
                        "\n" +
                        "​Gode råd til mor:\n" +
                        "\n" +
                        "Vær forberedt på at amme mange gange dagligt.\n" +
                        "Lad være med at give barnet sut før amningen er etableret.\n" +
                        "Hvil dig så meget som muligt.\n" +
                        "Husk at spise og drikke.\n" +
                        "Tilbyd brystet så ofte som muligt og lad barnet sutte længe."},
                {"Barnet er parat til at tage brystet med munden på vid gab. Når barnet har fået godt fat, er underlæben krænget godt ud og ligger et godt stykke inde på brystet. Undertiden kan tungen ses i mundvigen. Det kan gøre ondt i starten af amningen, men efter nogle minutter skal amningen ikke være forbundet med stærke smerter."},
                {"Det kan være et tegn på, at barnet får for lidt af den fede mælk. Vær opmærksom på, at barnet sutter det første bryst blødt, inden det andet bryst tilbydes. Det er almindeligt, at barnet nogle gange i døgnet - ofte sidst på dagen - gerne vil ammes hyppigt. Nogle spædbørn vil gerne sutte igen kort tid efter amningen. Typisk er det kun 5-10 min., hvorefter barnet falder i søvn"},
                {"Når barnet kommer med tydelige synkelyde efter at have suttet i kort tid.\n" +
                        "Når barnet har 6-8 våde bleer dagligt. \n" +
                        "Når afføringen ændrer sig fra at være tykt og mørkegrøn til at være gul og grynet"},
                {"Sørg for at barnet har godt fat om brystet.\n" +
                        "Barnet skal ligge lige mod brystet så det ikke trækker i brystvorten.\n" +
                        "Er brysterne ømme, så start med det mindst ømme bryst og flyt barnet til det mest ømme bryst, når mælken løber.\n" +
                        "Har jeres barn svært ved at få fat, kan det hjælpe at ”starte forfra”. Dvs. at lægge barnet hud mod hud på mors mave/bryst i mange timer og lade barnet få tid og ro til at finde vej til brystet igen.\n" +
                        "Få mælken til at løbe før du lægger barnet til brystet.\n" +
                        "Prøv med en anden ammestilling.\n" +
                        "Bryd vacuumet mellem brystvorten og barnets mund, inden vorten tages ud af barnets mund.\n" +
                        "Lad vorterne lufttørre, evt. med lidt modermælk på.\n" +
                        "Brug BH og undgå, at tøj irriterer brystvorterne.\n" +
                        "Undgå ammeindlæg der klæber til huden. Brug helst uldne ammeindlæg.\n" +
                        "Der er ingen dokumentation for at brug af cremer kan hjælpe.\n" +
                        "Vær opmærksom på, at der kan være svamp i brystvorten, hvis brystvorten er blank og rødmende. Svamp kræver behandling."},
                {"Brystbetændelse opstår, hvis mælken hober sig op i et område af brystet. Det føles ofte som en knude og området omkring bliver spændt og rødt.\n" +
                        "Symptomerne er influenzalignende med ømhed i hele kroppen – feber kan ligeledes forekomme."},
                {"Undgå tøj der strammer omkring brystet.\n" +
                        "Undgå at trykke hårdt på brystet i forbindelse med amning.\n" +
                        "Skift jævnligt ammestilling, så alle områder i brystet tømmes.\n" +
                        "Undgå kulde.\n" +
                        "\n" +
                        "Det kan være nødvendigt at behandle brystbetændelse med antibiotika.\n" +
                        "\n" +
                        "Kontakt den praktiserende læge, din sundhedsplejerske eller barselsafdelingen, hvis du tror du har fået brystbetændelse."},
                {"Hvis der er kommet store sår på brystvorterne, kan det lindre at bruge en suttebrik til sårene er helede.\n" +
                        "Hvis brystvorterne er flade eller indadvendte, og barnet ikke kan få fat."},
                {"Hvis brysterne er meget spændte, og barnet ikke kan få fat.\n" +
                        "Hvis vorterne er meget ømme pga. revner eller sår.\n" +
                        "For at stimulere og øge mængden af mælk.\n" +
                        "Hvis barnet er for svagt til at sutte på brystet.\n" +
                        "Hvis mor og barn er adskilt i en periode.​"},
                {"Når amningen fungerer godt, mælken er løbet til, og barnet tager på i vægt, kan I godt tilbyde barnet en sut. I dagene indtil mælken er løbet til, er det almindeligt at barnet sutter hyppigt og længe. Efter mælken er løbet til, kan barnets ønske om ofte at ligge ved brystet, være et udtryk for at behovet for at sutte er stort. Her kan man evt. give barnet en sut."},
                {"De første 7 døgn efter fødslen kan I henvende jer i et af barselambulatorierne mandag–søndag kl. 8.30-14.30. Sundhedsplejersken kontakter jer, når I er kommet hjem og aftaler besøg. Ved behov kan I tage kontakt til hende.\n" +
                        "\n" +
                        "Forældre & Fødsel tilbyder telefonisk vejledning i amning."}
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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


}
