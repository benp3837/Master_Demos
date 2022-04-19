import React from "react";

import './Post.css'

export const Post:React.FC<any> = (post:any) => {
    return(

        <div className="post-container">
            <div className="post-profile">
                <img className="post-image" src='https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg' alt="meh"/>
                <h3 className="post-username">{post.username}</h3>
            </div>

            <div className="post-content">
                <p>{post.content}</p>
            </div>

        </div>
    )
}