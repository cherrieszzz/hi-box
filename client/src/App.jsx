import './App.css';
import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import HomePage from './components/pages/HomePage';
import PostPage from './components/pages/PostPage';
import NotFound from './components/pages/NotFound';
import SocialPage from './components/pages/SocialPage';
import LoginPage from './components/pages/LoginPage';
import AdminPage from "./components/pages/AdminPage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<HomePage />} />
        <Route path='/posts/:id' element={<PostPage />} />
        <Route path='*' element={<NotFound />} />
        <Route path='/social' element={<SocialPage />} />
        <Route path='/login' element={<LoginPage />} />
          <Route path='/admin' element={<AdminPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
