import { Address } from './Address';
export interface UserAccount {
  id: number;
  name: string;
  joinDate: Date;
  description: string;
  uselessField: string;
  address: Address;
}
