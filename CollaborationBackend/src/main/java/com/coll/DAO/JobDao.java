package com.coll.DAO;

import java.util.List;

import com.coll.Model.Job;

public interface JobDao
{
void addJob(Job job);


List<Job> getAllJobs();


}
