/**
 * Conduit API
 * Conduit API
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { NewUser } from './NewUser';

export class NewUserRequest {
    'user': NewUser;

    static readonly discriminator: string | undefined = undefined;

    static readonly attributeTypeMap: Array<{name: string, baseName: string, type: string, format: string}> = [
        {
            "name": "user",
            "baseName": "user",
            "type": "NewUser",
            "format": ""
        }    ];

    static getAttributeTypeMap() {
        return NewUserRequest.attributeTypeMap;
    }

    public constructor() {
    }
}

