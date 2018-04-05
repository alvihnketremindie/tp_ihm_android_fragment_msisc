package com.example.alvihn.myapplicationfragmenttpisic;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    protected MainFragment mf ;
    protected DisplayFragment df;
    protected boolean isDisplayFragment = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState) ;
        setContentView (R.layout.activity_main) ;
        mf = new MainFragment () ;
        if (savedInstanceState == null) {
            lancerFragment(mf);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Saving the bundle
        super.onSaveInstanceState(outState);
        outState.putBoolean("isDisplayFragment", isDisplayFragment);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("isDisplayFragment")) {
                boolean valDisplayFragment = savedInstanceState.getBoolean("isDisplayFragment");
            }
        }
    }


    public void onDisplayFragment () {
        this.setIsDisplayFragment(true);
        EditText editTextNom = (EditText) findViewById(R.id.editTextNom);
        EditText editTextPrenom = (EditText) findViewById(R.id.editTextPrenom);
        EditText editTextVille = (EditText) findViewById(R.id.editTextVille);
        //Toast appearance
        String textToShow = "Nom : "+editTextNom.getText().toString() + "\r\n"
                        + "Prenom : "+editTextPrenom.getText().toString() + "\r\n"
                        + "Ville : "+editTextVille.getText().toString() + "\r\n";
        Toast.makeText(getApplicationContext(), textToShow, Toast.LENGTH_SHORT).show();

        //DisplayFragmentAction
        df = new DisplayFragment () ;
        df.setNom (editTextNom.getText ()) ;
        df.setPrenom (editTextPrenom.getText ());
        df.setVille (editTextVille.getText ());

        remplacerFragment(df);
    }

    public void lancerFragment(Fragment fragment) {
        getFragmentManager ().beginTransaction ()
                .add (R.id.fragmentContainer, fragment)
                .commit() ;
    }

    public void remplacerFragment(Fragment fragment) {
        getFragmentManager ().beginTransaction ()
                .replace (R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit() ;
    }

    public void remplacerFragment(Fragment ancient_fragment, Fragment nouveau_fragment) {
        getFragmentManager ().beginTransaction ()
                .remove (ancient_fragment)
                .addToBackStack (null)
                .add (R.id.fragmentContainer, nouveau_fragment)
                .commit () ;
    }


    public void setIsDisplayFragment(boolean b) {
        isDisplayFragment = b;
    }

    public boolean getIsDisplayFragment() {
        return isDisplayFragment;
    }
}