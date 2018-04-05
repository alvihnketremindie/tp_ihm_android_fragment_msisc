package com.example.alvihn.myapplicationfragmenttpisic;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Alvihn on 28/03/2018.
 */

public class DisplayFragment extends Fragment {
    protected CharSequence nom;
    protected CharSequence prenom;
    protected CharSequence ville;

    protected MainActivity mainActivity;

    public void setNom(CharSequence nom) {
        this.nom = nom;
    }

    public void setPrenom(CharSequence prenom) {
        this.prenom = prenom;
    }

    public void setVille(CharSequence ville) {
        this.ville = ville;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_display, container, false);
        TextView tvDisplayNom = rootView.findViewById(R.id.textViewNomAffiche);
        TextView tvDisplayPrenom = rootView.findViewById(R.id.textViewPrenomAffiche);
        TextView tvDisplayVille = rootView.findViewById(R.id.textViewVilleAffiche);

        setTextViewField(tvDisplayNom, nom);
        setTextViewField(tvDisplayPrenom, prenom);
        setTextViewField(tvDisplayVille, ville);
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("nom", nom);
        outState.putCharSequence("prenom", prenom);
        outState.putCharSequence("ville", ville);
        outState.putBoolean("isDisplayFragment", mainActivity.getIsDisplayFragment());
    }

    public void setTextViewField(TextView textViewMeth, CharSequence charSequence) {
        if ((textViewMeth != null) && (charSequence != null)) {
            textViewMeth.setText(charSequence);
        }
    }
}