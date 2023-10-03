"use client";

import { useState } from "react";
import Conditional from "../components/conditional";
import TeamForm from "../components/teamform"

export default function Home() {

  let bool : boolean | undefined | null = null;

  function toggle() {
    bool = !bool;
    console.log(bool)
  }

  return (
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
          onClick={toggle}
          className="bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 border-b-4 border-blue-700 hover:border-blue-500 rounded">
            Create Team
          </button>
          <button className="ml-20 bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 border-b-4 border-blue-700 hover:border-blue-500 rounded">
            Create Member
          </button>
          <button className="ml-20 bg-blue-500 hover:bg-blue-400 text-white font-bold py-2 px-4 border-b-4 border-blue-700 hover:border-blue-500 rounded">
            Create Task
          </button>
        </div>
      </div>
    </main>
  );
}
