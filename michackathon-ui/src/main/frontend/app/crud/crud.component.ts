/* tslint:disable:no-unused-variable */
import {Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';
import {AuthService} from '../shared/auth/auth.service';

@Component({
  selector: 'michackathon-crud',
  templateUrl: './crud.component.html',
  styleUrls: ['./crud.component.scss']
})
export class CrudComponent implements OnInit {

  posts: BlogPost[] = [];

  editing: boolean = false;
  editedPost: BlogPost = null;

  constructor(public http: Http, public authService: AuthService) {
  }


  ngOnInit(): any {
    console.log('hello `Crud` component');
    this.fetchPosts();
  }

  public editPost(post: BlogPost) {
    this.editing = true;
    this.editedPost = JSON.parse(JSON.stringify(post));
    this.scrollToTop();
  }

  public newPost() {
    this.editing = true;
    this.editedPost = {
      id: null,
      title: '',
      content: '',
      createdDate: null,
      updatedDate: null,
      version: null,
      createdBy: null,
      updatedBy: null,
    };
  }

  public removePost(post: BlogPost) {
    this.deletePost(post);
  }

  public cancelEdit() {
    this.editing = false;
    this.editedPost = null;
    this.scrollToTop();
  }

  public refresh() {
    this.cancelEdit();
    this.fetchPosts();
  }

  private fetchPosts() {
    this.http.get('/api/posts/', {headers: this.authService.getAuthorizationHeaders()})
      .subscribe(
        data => {
          this.posts = data.json();
        },
        err => console.log('Something went wrong')
      );
  }

  private savePost(post: BlogPost) {
    this.http.post(`/api/posts/`, post, {headers: this.authService.getAuthorizationHeaders()})
      .subscribe(
        data => {
          console.log('Saved', data.json());
          this.updateOrAddPostToList(data.json());
        },
        err => console.log('Something went wrong')
      );
  }

  private deletePost(post: BlogPost) {
    this.http.delete(`/api/posts/${post.id}`, {headers: this.authService.getAuthorizationHeaders()})
      .subscribe(
        data => {
          console.log('Removed', data.json());
          this.removePostFromList(post);
        },
        err => console.log('Something went wrong')
      );
  }

  private removePostFromList(post: BlogPost) {
    this.posts = this.posts.filter((x, idx, obs) => x.id !== post.id);
    this.cancelEdit();
  }

  private updateOrAddPostToList(post: BlogPost) {
    let changedList: BlogPost[] = this.posts.filter((x, idx, obs) => x.id === post.id);
    if (changedList.length === 0) {
      this.posts.push(post);
    } else {
      changedList.forEach((x) => {
        let index = this.posts.indexOf(x);
        this.posts[index] = post;
      });
    }
    this.cancelEdit();
  }

  private scrollToTop() {
    let contentEl = document.querySelector('md-sidenav-layout > .md-sidenav-content');
    if (contentEl) {
      this.scrollTo(contentEl, 0, 100);
    }
  }

  private scrollTo(element, to, duration) {
    if (duration <= 0) {
      return;
    }
    let difference = to - element.scrollTop;
    let perTick = difference / duration * 10;

    setTimeout(() => {
      element.scrollTop = element.scrollTop + perTick;
      if (element.scrollTop === to) {
        return;
      }
      this.scrollTo(element, to, duration - 10);
    }, 10);
  }

}

export interface BlogPost {
  id: number;
  uuid?: string;
  title: string;
  content: string;
  createdDate: Date;
  updatedDate: Date;
  version: number;
  createdBy: any;
  updatedBy: any;
}
