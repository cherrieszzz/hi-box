import { useState } from "react";
import { LockClosedIcon } from "@heroicons/react/solid";
import nav_logo from '../../assets/logo.png'
import axios from "axios";

function SuccessModal() {
    return (
        <div className="alert alert-success shadow-lg">
            <div>
                <svg xmlns="http://www.w3.org/2000/svg" className="stroke-current flex-shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z" /></svg>
                <span>登陆成功!</span>
            </div>
        </div>
    )
}

function Error() {
    return (
        <div className="alert alert-error shadow-lg">
            <div>
                <svg xmlns="http://www.w3.org/2000/svg" className="stroke-current flex-shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z" /></svg>
                <span>Error! Task failed successfully.</span>
            </div>
        </div>
    )
}

function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [success, setSuccess] = useState(false);
    const [error, setError] = useState(false);

    const handleLogin = (e) => {
        e.preventDefault();
        // Do something with the username and password
        console.log(`Logged in with username: ${username} and password: ${password}`);
        axios.post('http://localhost:8001/user/login', { phone: username, password: password }).then((res) => {
            console.log(res.data.data);
            if (res.data.code == 200) {
                setError(false);
                setSuccess(true);
            }
            if(res.data.code !== 200) {
                setSuccess(false);
                setError(true);
                console.log(res.data.data.token);
                sessionStorage.setItem('token',res.data.data.token);
            }
        }).catch((err) => {
            console.log(err);
        })
    };

    return (
        <div className="flex h-screen bg-gray-200">
            <div className="m-auto w-96 bg-white rounded-lg shadow-lg p-6">
                <div className="text-center">
                    <img
                        className="h-20 mx-auto"
                        src={nav_logo}
                        alt="logo"
                    />
                    <h1 className="text-2xl font-black mt-2 ">登录Hibox</h1>
                </div>
                {success && <SuccessModal />}
                {error && <Error />}
                <form className="mt-6" onSubmit={handleLogin}>
                    <div>
                        <label className="block text-gray-600 font-semibold">用户名</label>
                        <input
                            type="text"
                            placeholder="Enter your username"
                            className="w-full px-4 py-2 mt-2 border rounded-lg text-gray-700 focus:outline-none focus:border-blue-500"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                        />
                    </div>
                    <div className="mt-4">
                        <label className="block text-gray-600 font-semibold">密码</label>
                        <input
                            type="password"
                            placeholder="Enter your password"
                            className="w-full px-4 py-2 mt-2 border rounded-lg text-gray-700 focus:outline-none focus:border-blue-500"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                    </div>
                    <div className="mt-6">
                        <button
                            type="submit"
                            className="w-full px-4 py-2 tracking-wide text-white bg-blue-500 rounded-lg hover:bg-blue-400 transition-colors"
                            onClick={handleLogin}
                        >
                            登录
                        </button>
                    </div>
                </form>
                <div className="mt-4 text-center">
                    <a href="#" className="text-blue-500 hover:text-blue-700 font-semibold">
                        忘记密码？
                    </a>
                </div>
                <div className="mt-4 flex justify-center">
                    <hr className="w-1/3" />
                    <p className="mx-2 text-gray-500 font-semibold">或</p>
                    <hr className="w-1/3" />
                </div>
                <div className="mt-4 flex justify-center items-center">
                    <button className="bg-blue-500 hover:bg-blue-400 text-white rounded-full p-2 mr-2 transition-colors">
                        <i className="fab fa-facebook-f"></i>
                    </button>
                    <button className="bg-gray-200 hover:bg-gray-300 text-gray-700 rounded-full p-2 transition-colors">
                        <i className="fab fa-google"></i>
                    </button>
                </div>
                <div className="mt-4 text-center">
                    <p className="text-gray-500">
                        没有账户?{" "}
                        <a href="#"
                            className="text-blue-500 hover:text-blue-700 font-semibold"
                        >
                            注册
                        </a>
                    </p>
                </div>
            </div>
        </div>
    );
}

export default Login;

