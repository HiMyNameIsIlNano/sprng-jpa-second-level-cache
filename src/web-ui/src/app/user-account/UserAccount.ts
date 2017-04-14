import { Address } from './Address';
export interface UserAccount {
  id: number;
  name: string;
  surname: string;
  email: string;
  password: string;
  joinDate: Date;
  description: string;
  profilePhotoUrl: string;
  address: Address;
}
