import { Injectable } from '@nestjs/common';
import * as bcrypt from 'bcrypt';

@Injectable()
export class UsersService {
  private users: User[];

  public async findUser(username: string): Promise<User> {
    try {
      return this.users.filter((user) => user.username === username)[0];
    } catch (e) {
      return {
        username: 'not found',
        password: 'not valid',
        email: 'no',
        bio: '',
        image: '',
        token: '',
      };
    }
  }

  public async register(newUserRequest: {
    user: { username: string; email: string; password: string };
  }): Promise<User> {
    let newUser: User = {
      ...newUserRequest.user,
      bio: 'bio',
      token: '',
      image: '',
    };
    const salt = await bcrypt.genSalt(10);
    newUser.password = await bcrypt.hash(newUser.password, salt);
    this.users.push(newUser);
    return newUser;
  }
}

interface User {
  username: string;
  password: string;
  email: string;
  token: string;
  bio: string;
  image: string;
}
