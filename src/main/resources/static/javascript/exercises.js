//Cookie
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

//DOM Elements
const exercisesContainer = document.getElementById("exercises-container")

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = "http://localhost:8080/api/fitness/exercises"

//Logout Method
function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

//Retrieve all exercises
async function getAllExercises() {
    await fetch(baseUrl, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createExerciseCards(data))
        .catch(err => console.error(err))
}

//Helper function that creates a card for each item and appends it to the exercises container
const createExerciseCards = (array) => {
    exercisesContainer.innerHTML = ''
    array.forEach(obj => {
        let exerciseCard = document.createElement("div")
        exerciseCard.classList.add("card")
        exerciseCard.innerHTML = `
            <div class="card-inside">
                <div class="card-body">

                    <p class="card-text" id="name">${obj.name}</p>
                    <img src=${obj.photo} alt="Exercise Photo" class="card-text" id="photo">
                    <a href=${obj.tutorial} target="_blank" rel="noopener noreferrer" class="card-text" id="tutorial">Exercise Tutorial</a>

                </div>
            </div>
        `
        exercisesContainer.append(exerciseCard);
    })
}

//Get exercises method
getAllExercises();
