package com.example.pbbsattendance.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.domain.model.UserModel
import com.example.domain.model.dto.IdDto
import com.example.domain.model.type.TypeUser
import com.example.pbbsattendance.R
import com.example.pbbsattendance.databinding.FragmentHomeBinding
import com.example.pbbsattendance.util.mapPepTalk
import com.example.pbbsattendance.util.mapUserType
import com.example.pbbsattendance.viewmodel.HomeViewModel
import com.github.tlaabs.timetableview.Schedule
import com.github.tlaabs.timetableview.Time
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var navController: NavController
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel by viewModels<HomeViewModel>()
    lateinit var userData: UserModel
    private var scheduleList = arrayListOf<Schedule>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val baseInflater = LayoutInflater.from(requireActivity())
        _binding = DataBindingUtil.inflate(baseInflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = this@HomeFragment.findNavController()
        binding.viewModel = homeViewModel

        binding.apply {
            viewModel?.getUser(IdDto(id=5))

            icPlusSchedule.setOnClickListener {
                view.findNavController().navigate(R.id.action_homeFragment_to_lectureAddFragment)
            }
            icEditSchedule.setOnClickListener {
                val schedule = Schedule()
                schedule.startTime = Time(10,0)
                schedule.endTime = Time(13,10)
                schedule.classTitle = "세미나"
                schedule.day = 1
                scheduleList.add(schedule)
                timetable.add(scheduleList)
            }
            timetable.setOnStickerSelectEventListener{ i: Int, schedules: ArrayList<Schedule> ->
                Log.i("HomeFragment::i", i.toString())
                Log.i("HomeFragment::", timetable.id.toString())
                //Log.i("HomeFragment::info", "${schedules[i].classTitle}, ${schedules[i].classPlace}")
                viewModel?.postScheduleSubjectEvent(i)
                when(userData.typeUser){
                    TypeUser.PROFESSOR -> view.findNavController().navigate(R.id.action_homeFragment_to_professorViewPagerFragment)
                    TypeUser.STUDENT -> view.findNavController().navigate(R.id.action_homeFragment_to_studentViewPagerFragment)
                    else -> null
                }
            }
            timetable.


            viewModel?.user?.observe(viewLifecycleOwner, Observer {
                viewModel?.showScheduleSubjects(IdDto(it.id!!))
                userData = it
                userName.text = userData.nameUser
                userType.text = mapUserType(userData.typeUser?.koName)
                peptalk.text = mapPepTalk(userData.typeUser?.koName)
            })

            viewModel?.scheduleSubjectsResult?.observe(viewLifecycleOwner, Observer {
                timetable.add(it)
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}