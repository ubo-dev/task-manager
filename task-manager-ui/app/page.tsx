"use client";

import { useState } from "react";
import TeamForm from "@/components/teamform";
import React from "react";
import MemberForm from "@/components/memberForm";
import TaskForm from "@/components/taskForm";

export default function Home() {
  const [toggleTeam, setToggleTeam] = useState(false);
  const [toggleMember, setToggleMember] = useState(false);
  const [toggleTask, setToggleTask] = useState(false);

  function toggleTeamForm() {
    setToggleTeam(!toggleTeam);
  }

  function toggleMemberForm() {
    setToggleMember(!toggleMember);
  }

  function toggleTaskForm() {
    setToggleTask(!toggleTask);
  }

  return (
    <>
      <main className="flex min-h-screen flex-col items-center justify-between p-12">
        <div>
          <h1 className="flex flex-col items-center p-24 text-4xl">
            {" "}
            Welcome to Task Manager{" "}
          </h1>
          <h2>
            You can create tasks, teams, members. Assign tasks and manage them.
          </h2>

          <div className="pt-12 flex flex-row items-center">
            <button
              onClick={toggleTeamForm}
              className="bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 border-b-4 border-blue-700 hover:border-blue-500 rounded"
            >
              Create Team
            </button>
            <button
              onClick={toggleMemberForm}
              className="ml-20 bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 border-b-4 border-blue-700 hover:border-blue-500 rounded"
            >
              Create Member
            </button>
            <button
              onClick={toggleTaskForm}
              className="ml-20 bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 border-b-4 border-blue-700 hover:border-blue-500 rounded"
            >
              Create Task
            </button>
          </div>

          <TeamForm isToggled={toggleTeam}></TeamForm>

          <MemberForm isToggled={toggleMember}></MemberForm>

          <TaskForm isToggled={toggleTask}></TaskForm>
        </div>
      </main>
    </>
  );
}
