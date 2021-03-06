package br.edu.ufcg.ccc.prototipo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class HistoricoFragment extends Fragment implements OnItemClickListener {
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.historico_fragment, container, false);
      return view;
   }
   
   @Override
   public void onActivityCreated(Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);
      ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Planets, android.R.layout.simple_list_item_1);

   }
   
   @Override
   public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
      Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
   }
}