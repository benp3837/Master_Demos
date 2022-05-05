import React, {useState, useEffect} from "react";

import { Post } from '../Post/Post';

export const PostContainer:React.FC<any> = (data) => {

    //useState is a hook that lets you store and change a state in a function component
    //we declare a state variable (posts) and a mutator (setPosts) to change the state.
    let [posts, setPosts] = useState([]);

    //useEffect is a hook that allows you to perform some logic at specific points during runtime
    //can be used to watch for specific events to perform some logic
    //here, for every object in posts, put it's data in the posts array 
    useEffect(() => {
        setPosts(data.data);
    }, [posts])

    return(
        /* .map() is a function that lets you render a list of elements*/
        /* You're expected to provide a unique key for the element you're mapping through*/
        /* So this is saying... 
        //for every object (called post) in posts, render a Post component holding that data*/
        <div>
            {posts.map((post:any) => {
            return <Post {...post} key={post.postId}/>
            })}
        </div>
    )

}