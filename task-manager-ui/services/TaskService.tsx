import axios from "axios";

const TASK_BASE_URL = "http://localhost:8080/v1/task"

interface Task {
    title : string,
    description : string
}

class TaskService {

    saveTask(task : Task) {
        console.log(task)
        return axios.post(TASK_BASE_URL, {task})
    }
}

export default new TaskService();