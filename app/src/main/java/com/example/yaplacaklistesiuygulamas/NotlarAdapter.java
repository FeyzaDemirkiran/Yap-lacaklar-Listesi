package com.example.yaplacaklistesiuygulamas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
// notları Recylerview içinde göstermek için kullanılan adapter
public class NotlarAdapter extends RecyclerView.Adapter<NotlarAdapter.NotlarViewHolder> {
    //Notlar Listesi
    private List<Not> notlar;
    //Listeyle ilgili arayüz
    private OnNotClickListener listener;

    //constructor
    public NotlarAdapter(List<Not> notlar, OnNotClickListener listener){
        this.notlar = notlar;
        this.listener = listener;
    }

    // Listeyi güncelleyen constructor

    public void setNotlar(List<Not> notlar) {
        this.notlar = notlar;
        notifyDataSetChanged (); // veri değişikliliğini bildirerek görünümü yeniler.
    }

// Satır xmlinin bağlanması
    @NonNull
    @Override
    public NotlarAdapter.NotlarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext () ).inflate(R.layout.notlar_satiri,parent,false);
        return new NotlarViewHolder (view);
    }
// Verileri bağlama
    @Override
    public void onBindViewHolder(@NonNull NotlarAdapter.NotlarViewHolder holder, int position) {
    Not not =notlar.get (position);

    // Verileri aktarma
    holder.baslikTextView.setText(not.getBaslik());
    holder.icerikTextView.setText(not.getIcerik ());

    //button click listener
   holder.silButton.setOnClickListener ( new View.OnClickListener () {
       @Override
       public void onClick(View v) {
           listener.onSilmeClick ( not );
       }
   });

   holder.guncelleButton.setOnClickListener ( new View.OnClickListener () {
       @Override
       public void onClick(View v) {
           listener.onGuncellemeClick ( not );
       }
   } );
    }
// Not listesinde ki öğe sayısını döndürür.
    @Override
    public int getItemCount() {
        return notlar.size();
    }
//view holder
    public class NotlarViewHolder extends RecyclerView.ViewHolder {
        private TextView baslikTextView;
        private TextView icerikTextView;

        private Button silButton;

        private Button guncelleButton;

        public NotlarViewHolder(@NonNull View itemView) { //her bir not satırını temsil eder.
            super ( itemView );

            baslikTextView = itemView.findViewById (R.id.not_basligi);
            icerikTextView = itemView.findViewById (R.id.not_icerigi );

            silButton = itemView.findViewById (R.id.not_sil_button);
            guncelleButton = itemView.findViewById (R.id.not_guncelle_button);


        }
    }
   //interface
    public interface OnNotClickListener
    {
        void onSilmeClick(Not not);
        void onGuncellemeClick(Not not);
    }
}
