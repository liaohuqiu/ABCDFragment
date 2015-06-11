package demos.srain.in.abcdfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentA extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_a, null);
        ViewPager pager = (ViewPager) view.findViewById(R.id.view_pager_view_pager);

        List<FragmentBC> list = new ArrayList<FragmentBC>();
        String[] titles = new String[]{"B", "C"};
        for (int i = 0; i < titles.length; i++) {
            list.add(FragmentBC.create(titles[i]));
        }
        pager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager(), list));
        return view;
    }


    public class MyPagerAdapter extends FragmentPagerAdapter {

        private List<FragmentBC> mList;

        public MyPagerAdapter(FragmentManager fm, List<FragmentBC> list) {
            super(fm);
            mList = list;
        }

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }
    }
}


