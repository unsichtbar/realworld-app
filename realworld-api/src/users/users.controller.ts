import { Body, Controller, Post } from '@nestjs/common';
import { LoginUserRequest, NewUserRequest, UserResponse } from 'src/openapi';
import { UsersService } from './users.service';

@Controller('/users')
export class UsersController {
  constructor(private userService: UsersService) {}

  @Post('/login')
  public async loginUser(
    @Body() body: LoginUserRequest,
  ): Promise<UserResponse> {
    return { user: {} } as any;
  }

  @Post('/')
  public async register(@Body() body: NewUserRequest): Promise<UserResponse> {
    return;
  }
}
