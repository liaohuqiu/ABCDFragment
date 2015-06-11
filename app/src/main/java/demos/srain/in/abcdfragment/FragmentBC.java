package demos.srain.in.abcdfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentBC extends Fragment {

    private String mTitle;

    public static FragmentBC create(String title) {
        FragmentBC fragment = new FragmentBC();
        fragment.mTitle = title;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_text, null);
        TextView textView = (TextView) view.findViewById(R.id.fragment_text_text_view);
        textView.setBackgroundColor(0xff4d90fe * (mTitle.hashCode() % 100) / 30);
        textView.setText("Page: " + mTitle);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentD dFrag = new FragmentD();
                ft.add(R.id.fragment_text_fragment, dFrag, "dFrag");
                ft.commit();
            }
        });
        return view;
    }
}
