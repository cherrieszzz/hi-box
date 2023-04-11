import './App.css';
import React from 'react';
import PostCard from './components/PostCard';
import posts from './data/posts';

function App() {
  return (
    <div className="App">
      {
        posts.map((post) => (
          <PostCard key={post.id} post={post} />
        ))
      }
    </div>
  );
}

export default App;
