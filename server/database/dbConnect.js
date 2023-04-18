const mongoose = require('mongoose');

function dbConnect() {
    mongoose.connect(process.env.DB_URL, (err) => {
        console.log("Database are connected!");
        if(err) {
            console.log(err);
        }
    })
}

export default dbConnect;

