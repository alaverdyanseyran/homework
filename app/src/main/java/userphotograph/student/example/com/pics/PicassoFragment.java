package userphotograph.student.example.com.pics;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;


public class PicassoFragment extends Fragment {
    //private ImageView pic;
    private List<PicsModel> picModelList;
    private RecyclerView picRecyclerView;
    private DatabaseReference mDatabaseRef;
    private FirebaseRecyclerAdapter<PicsModel, PicHolder> mRecAdap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_picasso, container, false);
        init(view);
        //writeWithFbDb();
        //pic=(ImageView) view.findViewById(R.id.picassoImage);

        // Picasso.with(getContext()).load("http://www.celesteprize.com/_files/opere/2014_68287_266667.jpg").fit().centerCrop().into(pic);
        // Inflate the layout for this fragment
        return view;
    }

    private void init(View v) {
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("picasso");
        picRecyclerView = (RecyclerView) v.findViewById(R.id.picasso_list);
        //picRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        picRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        picRecyclerView.setHasFixedSize(true);
        //onCreateFirebaseRecyclerAdapter(picRecyclerView);
        setupAdapter();

    }

    private void setupAdapter() {

        mRecAdap = new FirebaseRecyclerAdapter<PicsModel, PicHolder>(
                PicsModel.class, R.layout.picasso_item,
                PicHolder.class, mDatabaseRef
        ) {
            @Override
            protected void populateViewHolder(PicHolder viewHolder, PicsModel model, int position) {
                Picasso.with(getContext()).load(model.imageURL).into(viewHolder.pic);
                   // viewHolder.pic.setText(model.imageURL);
            }
        };
        picRecyclerView.setAdapter(mRecAdap);
    }

    public static class PicHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        public PicHolder(View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.pic);
        }

    }

    private void writeWithFbDb() {
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.child("imageURL").getValue(String.class);

            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }
}