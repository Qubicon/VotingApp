package ro.unibuc.votingapp.presentation.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ro.unibuc.votingapp.R;
import ro.unibuc.votingapp.presentation.VotingAppViewModel;
import ro.unibuc.votingapp.presentation.view.RecyclerViewActivity;

public final class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View root = super.onCreateView( inflater, container, savedInstanceState );
        if ( root != null ) {
            TextView textView = root.findViewById( R.id.text_home );
            textView.setText( String.format( getString( R.string.welcome ), VotingAppViewModel.getUserName() ) );
        }
        //butonul cu care vom accesa panoul cu scoruri
        FloatingActionButton fab = requireView().findViewById( R.id.fabhome );
        fab.setOnClickListener( view -> {
            Intent intent = new Intent( requireContext(), RecyclerViewActivity.class );
            Bundle bundle = new Bundle();
            bundle.putString( "tip", "news" );
            intent.putExtras( bundle ); //Put your id to your next Intent
            requireContext().startActivity( intent );//cream o noua activitate pt utilizatorul specific
        } );
        return root;
    }

    public HomeFragment( int contentLayoutId ) {
        super( contentLayoutId );
    }
}
