# DefaultApi

All URIs are relative to *http://<host>:<port>/camera*

Method | HTTP request | Description
------------- | ------------- | -------------
[**imageGet**](DefaultApi.md#imageGet) | **GET** /image | Get image.
[**settingsAECOMPENSATIONGet**](DefaultApi.md#settingsAECOMPENSATIONGet) | **GET** /settings/AE_COMPENSATION | 
[**settingsAECOMPENSATIONPut**](DefaultApi.md#settingsAECOMPENSATIONPut) | **PUT** /settings/AE_COMPENSATION | 
[**settingsAELOCKGet**](DefaultApi.md#settingsAELOCKGet) | **GET** /settings/AE_LOCK | 
[**settingsAELOCKPut**](DefaultApi.md#settingsAELOCKPut) | **PUT** /settings/AE_LOCK | 
[**settingsFOCUSMODEGet**](DefaultApi.md#settingsFOCUSMODEGet) | **GET** /settings/FOCUS_MODE | 
[**settingsFOCUSMODEPut**](DefaultApi.md#settingsFOCUSMODEPut) | **PUT** /settings/FOCUS_MODE | 
[**settingsGet**](DefaultApi.md#settingsGet) | **GET** /settings | Get settings.
[**settingsISOGet**](DefaultApi.md#settingsISOGet) | **GET** /settings/ISO | 
[**settingsISOPut**](DefaultApi.md#settingsISOPut) | **PUT** /settings/ISO | 
[**settingsSettingGet**](DefaultApi.md#settingsSettingGet) | **GET** /settings/{setting} | Get setting info.
[**settingsSettingPut**](DefaultApi.md#settingsSettingPut) | **PUT** /settings/{setting} | Set setting value.


<a name="imageGet"></a>
# **imageGet**
> byte[] imageGet()

Get image.

Retrieve the current camera image.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    byte[] result = apiInstance.imageGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#imageGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**byte[]**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: image/jpeg

<a name="settingsAECOMPENSATIONGet"></a>
# **settingsAECOMPENSATIONGet**
> AECompensationInfo settingsAECOMPENSATIONGet()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    AECompensationInfo result = apiInstance.settingsAECOMPENSATIONGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settingsAECOMPENSATIONGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AECompensationInfo**](AECompensationInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settingsAECOMPENSATIONPut"></a>
# **settingsAECOMPENSATIONPut**
> settingsAECOMPENSATIONPut(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
AECompensationValue body = new AECompensationValue(); // AECompensationValue | 
try {
    apiInstance.settingsAECOMPENSATIONPut(body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settingsAECOMPENSATIONPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AECompensationValue**](AECompensationValue.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settingsAELOCKGet"></a>
# **settingsAELOCKGet**
> AELockInfo settingsAELOCKGet()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    AELockInfo result = apiInstance.settingsAELOCKGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settingsAELOCKGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**AELockInfo**](AELockInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settingsAELOCKPut"></a>
# **settingsAELOCKPut**
> settingsAELOCKPut(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
AELockValue body = new AELockValue(); // AELockValue | 
try {
    apiInstance.settingsAELOCKPut(body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settingsAELOCKPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**AELockValue**](AELockValue.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settingsFOCUSMODEGet"></a>
# **settingsFOCUSMODEGet**
> FocusModeInfo settingsFOCUSMODEGet()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    FocusModeInfo result = apiInstance.settingsFOCUSMODEGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settingsFOCUSMODEGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**FocusModeInfo**](FocusModeInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settingsFOCUSMODEPut"></a>
# **settingsFOCUSMODEPut**
> settingsFOCUSMODEPut(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
FocusModeValue body = new FocusModeValue(); // FocusModeValue | 
try {
    apiInstance.settingsFOCUSMODEPut(body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settingsFOCUSMODEPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**FocusModeValue**](FocusModeValue.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settingsGet"></a>
# **settingsGet**
> List&lt;Setting&gt; settingsGet()

Get settings.

Retrieve a set of the exposed settings of the camera.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<Setting> result = apiInstance.settingsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settingsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Setting&gt;**](Setting.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settingsISOGet"></a>
# **settingsISOGet**
> ISOInfo settingsISOGet()



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    ISOInfo result = apiInstance.settingsISOGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settingsISOGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ISOInfo**](ISOInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settingsISOPut"></a>
# **settingsISOPut**
> settingsISOPut(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
ISOValue body = new ISOValue(); // ISOValue | 
try {
    apiInstance.settingsISOPut(body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settingsISOPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ISOValue**](ISOValue.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settingsSettingGet"></a>
# **settingsSettingGet**
> SettingInfo settingsSettingGet(setting)

Get setting info.

Retrieve information about the specified setting.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String setting = "setting_example"; // String | 
try {
    SettingInfo result = apiInstance.settingsSettingGet(setting);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settingsSettingGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **setting** | **String**|  | [enum: ISO, FOCUS_MODE, AE_COMPENSATION, AE_LOCK]

### Return type

[**SettingInfo**](SettingInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="settingsSettingPut"></a>
# **settingsSettingPut**
> settingsSettingPut(setting, body)

Set setting value.

Update the value of the specified setting. Refer to /settings/{setting} for the valid values of the specified setting. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String setting = "setting_example"; // String | 
SettingValue body = new SettingValue(); // SettingValue | 
try {
    apiInstance.settingsSettingPut(setting, body);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#settingsSettingPut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **setting** | **String**|  | [enum: ISO, FOCUS_MODE, AE_COMPENSATION, AE_LOCK]
 **body** | [**SettingValue**](SettingValue.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

