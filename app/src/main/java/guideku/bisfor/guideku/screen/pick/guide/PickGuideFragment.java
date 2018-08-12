package guideku.bisfor.guideku.screen.pick.guide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import guideku.bisfor.guideku.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PickGuideFragment extends Fragment {


    public PickGuideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pick_guide, container, false);
    }

}
