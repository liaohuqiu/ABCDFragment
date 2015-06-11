package demos.srain.in.abcdfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentD extends Fragment {

    private int mPage;

    public static FragmentD create(int page) {
        FragmentD fragment = new FragmentD();
        fragment.mPage = page;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, null);
        TextView textView = (TextView) view.findViewById(R.id.fragment_text_text_view);
        textView.setBackgroundColor(0xff4d90fe * (mPage + 1) / 30);
        textView.setText("D, click to Hide A, B, C");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                String fragmentTag = "FragmentA";
                Fragment fragment = fm.findFragmentByTag(fragmentTag);
                ft.hide(fragment);
                ft.commitAllowingStateLoss();
            }
        });
        return view;
    }
}
