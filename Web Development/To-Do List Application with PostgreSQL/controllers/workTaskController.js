import model from "../models/workTaskModel.js";

async function getAllTasks(req, res) {
    const tasks = await model.findAll();
    res.render("work.ejs", { tasks: tasks });
}

async function addTask(req, res) {
    const task = await model.create({ task: req.body.task });
    res.redirect("/work");
}

async function deleteTask(req, res) {
    await model.destroy({
        where: {
            id: req.params.id
        }
    });
    res.status(200).end();
}

export { getAllTasks, addTask, deleteTask };