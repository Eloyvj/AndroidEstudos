package com.example.eloyvitorio.appwithsettings;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragmentCompat {

    /**
     * Called during onCreate(Bundle) to supply the preferences for this
     * fragment. This calls setPreferenceFromResource to get the preferences
     * from the XML file.
     *
     * @param savedInstanceState If the fragment is being re-created from a previous saved state,
     *                          this is the state.
     * @param rootKey If non-null, this preference fragment should be rooted with this key.
     */
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setPreferencesFromResource(R.xml.preferences, rootKey);

    }
}
