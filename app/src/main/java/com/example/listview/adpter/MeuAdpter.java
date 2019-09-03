package com.example.listview.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listview.MainActivity;
import com.example.listview.R;
import com.example.listview.modelos.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MeuAdpter extends ArrayAdapter<Tarefa> {


    private Context context;
    private List<Tarefa> tarefas;


    public MeuAdpter(Context context, ArrayList<Tarefa> list){

        super(context, 0,list);
        this.context = context;
        tarefas = list;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listItem = convertView;
        if(listItem==null){
            listItem = LayoutInflater.from(context).inflate(R.layout.layout_lista,parent,false);
        }

        Tarefa tarefaAtual = tarefas.get(position);
        TextView nome = listItem.findViewById(R.id.tarefa_nome);
        nome.setText(tarefaAtual.getNome());
        TextView status = listItem.findViewById(R.id.tarefa_status);
        status.setText(tarefaAtual.getStatus().toString());



       if(!tarefaAtual.getStatus()){
           TextView concluir = listItem.findViewById(R.id.tarefa_status);
           concluir.setText("Falta Terminar");
           concluir.setTextColor(context.getResources().getColor(R.color.Terminar));

       }
       else{
           TextView concluir = listItem.findViewById(R.id.tarefa_status);
           concluir.setText("Concluido");
           concluir.setTextColor(context.getResources().getColor(R.color.Concluir));


       }




        return listItem;



    }
}

