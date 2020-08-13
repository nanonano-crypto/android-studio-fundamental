package com.juara.nav_drawer.ui.menu_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.juara.nav_drawer.R;

public class Menu1Fragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
      View root = inflater.inflate(R.layout.fragment_menu_1, container, false);
      final  TextView textView = root.findViewById(R.id.text_home);
      return root;
    }
}