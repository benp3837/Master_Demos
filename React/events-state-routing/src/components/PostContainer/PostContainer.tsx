import React, {useState, useEffect} from "react";

import { Post } from '../Post/Post';

export const PostContainer:React.FC<any> = (data) => {

    //useState is a hook that lets you store and change a state in a function component
    //we declare a state variable (posts) and a mutator (setPosts) to change the state.
    let [posts, setPosts] = useState([]);

    //useEffect is a hook that allows you to perform some logic at specific points during runtime
    //can be used to watch for specific events to perform some logic
    //here, 
    useEffect(() => {
        setPosts(data.data);
    }, [posts])

    return(
        /* .map() is a function that lets you render a list of elements*/
        /* You're expected to provide a unique key for the element you're mapping through*/
        /* So this is saying for every post in posts, render a Post component holding the data*/
        <div>
            {posts.map((post:any) => {
            {console.log(post)}
            return <Post {...post} key={post.postId}/>
            })}
        </div>
    )

}