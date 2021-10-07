package com.example.a160419133_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a160419133_uts.R
import kotlinx.android.synthetic.main.fragment_about.*

class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView2.text = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam mattis blandit facilisis. Aenean sed faucibus elit. Quisque hendrerit est in dolor pellentesque mattis. Vestibulum aliquam arcu eget turpis faucibus, sit amet blandit tellus mollis. Aliquam ac eros id velit fringilla venenatis. Fusce pulvinar tempus est. Fusce ut gravida nunc. Integer nec interdum magna. Morbi vel elementum orci. Duis nunc nisi, pulvinar sit amet metus non, consequat tincidunt nulla. Proin eu velit sed neque aliquet fringilla sit amet sed tellus.\n" +
                "\n" +
                "In euismod tellus mauris, vitae finibus erat semper ac. Praesent in tortor eget magna interdum egestas. Quisque non malesuada sapien. Etiam et dapibus ante. Pellentesque vehicula consequat arcu, sed venenatis metus suscipit nec. Aliquam erat volutpat. Aenean ac efficitur diam, id lobortis neque. Quisque viverra vehicula ultricies. In hac habitasse platea dictumst. Donec vehicula lobortis lectus, vitae elementum nunc condimentum vel. Nam in consectetur ipsum. Aliquam auctor sagittis velit vitae maximus. Phasellus eu nisi in turpis blandit semper vitae eget sapien. Ut in ligula id nulla lobortis finibus ac eget erat. Nullam odio massa, tempor sed rhoncus eu, convallis eu nibh. Sed sed eros ultrices, condimentum leo convallis, cursus sem. "
    }
}