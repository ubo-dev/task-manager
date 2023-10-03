import TaskService from "@/services/TaskService";
import { SetStateAction, useState } from "react";

export default function TaskForm({ isToggled }: { isToggled: boolean | undefined }) {

    const [task, setTask] = useState(
        {
            title: "",
            description: ""
        }
    )

    const saveTask = () => {
        TaskService.saveTask(task);
    }

    const handleChange = (event : any) => {
        setTask(event.target.value);
      };

    if (isToggled) {
      return (
        <form className="w-full max-w-lg mt-28">
          <div className="flex flex-wrap -mx-3 mb-6">
            <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
              <label
                className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                htmlFor="grid-task-title"
              >
                Task Title
              </label>
              <input
                className="appearance-none block w-full bg-gray-200 text-gray-700 border rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
                id="grid-task-title"
                type="text"
                placeholder="Task Title"
                value={task.title}
                onChange={handleChange}
              />
            </div>
            <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
              <label
                className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                htmlFor="grid-team-desc"
              >
                Task Description
              </label>
              <input
                className="appearance-none block w-full bg-gray-200 text-gray-700 border rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
                id="grid-last-name"
                type="description"
                placeholder="Task Description"
                value={task.description}
                onChange={handleChange}
              />
            </div>
          </div>
          <button 
          onClick={saveTask}
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 border border-blue-700 rounded-xl"> Send! </button>
        </form>
      );
    } else return null;
  }
  