package userphotograph.student.example.com.pics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


public class GlideFragment extends Fragment {

    ImageView pic;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_glide, container, false);
        pic=(ImageView) view.findViewById(R.id.glideImage);
        Glide.with(getContext()).load("https://vignette3.wikia.nocookie.net/uncyclopedia/images/c/ce/Hallucination.gif").into(pic);
        // Inflate the layout for this fragment
        return view;
    }

}