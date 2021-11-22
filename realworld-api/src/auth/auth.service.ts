import { Injectable } from '@nestjs/common';
import { UsersService } from 'src/users/users.service';
import * as bcrypt from 'bcrypt';
@Injectable()
export class AuthService {
  private SALT_ROUNDS = 10;

  constructor(private usersService: UsersService) {}

  async validateUser(username: string, password: string): Promise<any> {
    const user = await this.usersService.findUser(username);
    if (user) {
      const matches = await bcrypt.compare(password, user.password);
      if (matches) {
        return user;
      }
    }
    return null;
  }
}
